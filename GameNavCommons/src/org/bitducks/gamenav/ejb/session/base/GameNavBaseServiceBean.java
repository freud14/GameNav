
package org.bitducks.gamenav.ejb.session.base;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.bitducks.gamenav.entityutil.JoueurDroitService;
import org.bitducks.gamenav.entityutil.JoueurService;
import org.bitducks.gamenav.entityutil.JoueurUniversService;
import org.bitducks.gamenav.entityutil.PlaneteService;
import org.bitducks.gamenav.entityutil.RessourceService;
import org.bitducks.gamenav.entityutil.UniversService;

public abstract class GameNavBaseServiceBean {

	@PersistenceContext(unitName = "GameNavPU")
	protected EntityManager			em;

	@Resource
	private EJBContext				ctx;

	protected JoueurDroitService	joueurDroitService;

	protected JoueurService			joueurService;

	protected JoueurUniversService	joueurUniversService;

	protected PlaneteService		planeteService;

	protected RessourceService		ressourceService;

	protected UniversService		universService;

	public GameNavBaseServiceBean() {

		this.joueurDroitService = this.getService("JoueurDroit",
				JoueurDroitService.class);
		this.joueurService = this.getService("Joueur", JoueurService.class);
		this.joueurUniversService = this.getService("JoueurUnivers",
				JoueurUniversService.class);
		this.planeteService = this.getService("Planete", PlaneteService.class);
		this.ressourceService = this.getService("Ressource",
				RessourceService.class);
		this.universService = this.getService("Univers", UniversService.class);
	}

	@SuppressWarnings("unchecked")
	private <T> T getService(final String name, final Class<T> clazz) {

		return (T) Proxy.newProxyInstance(clazz.getClassLoader(),
				new Class[] { clazz }, new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method,
							Object[] args) throws Throwable {

						// if (!clazz.equals(method.getDeclaringClass())) {
						// return method.invoke(proxy, args);
						// }

						Query query = GameNavBaseServiceBean.this.em.createNamedQuery(name
								+ "." + method.getName());

						if (args != null) {
							int i = 1;
							for (Object arg : args) {
								query.setParameter(i, arg);
								++i;
							}
						}

						if (method.getReturnType().equals(List.class)) {
							return query.getResultList();
						} else {
							return query.getSingleResult();
						}
					}

				});
	}
}
