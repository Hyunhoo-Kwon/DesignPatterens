package chapter03.intro.domain;

import org.junit.Test;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

public class MapSiteTest {

    @Test
    public void canCreate() {
        MapSite mapSite = new MapSite() {
            @Override
            public void enter() {

            }
        };

        assertThat(mapSite, instanceOf(MapSite.class));
    }
}
