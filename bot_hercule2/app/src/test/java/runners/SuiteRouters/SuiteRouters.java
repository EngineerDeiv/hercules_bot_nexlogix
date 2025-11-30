package runners.SuiteRouters;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import runners.CreateVehicleRunner;
import runners.views_and_search_routes;
import runners.views_and_search_cities;
import runners.ViewsAndSearchVehiculos;
import runners.views_and_search_drivers;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CreateVehicleRunner.class,
        ViewsAndSearchVehiculos.class,
        views_and_search_routes.class,
        views_and_search_cities.class,
        views_and_search_drivers.class,


})
public class SuiteRouters {
}

