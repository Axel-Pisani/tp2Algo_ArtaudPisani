import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class EditDistanceTest {

    @Test
    public void testDistanceBetween() {
        assertThat(EditDistance.distanceBetween("mottest", "testmot"), equalTo(5));
        assertThat(EditDistance.distanceBetween("azertyuiop", "qwertyuiop"), equalTo(2));
        assertThat(EditDistance.distanceBetween("Test", "test"), equalTo(1));
        assertThat(EditDistance.distanceBetween("mot", "test"), equalTo(3));
    }
}