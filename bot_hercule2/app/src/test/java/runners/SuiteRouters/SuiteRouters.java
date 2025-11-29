package runners.SuiteRouters;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import runners.auth_nexlogix;
import runners.views_and_search_routes;
import runners.views_and_search_cities;
import runners.views_and_search_drivers;
import runners.ViewsAndSearchVehiculos;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        views_and_search_routes.class,
        views_and_search_cities.class,
        views_and_search_drivers.class,
        ViewsAndSearchVehiculos.class
})
public class SuiteRouters {
}

