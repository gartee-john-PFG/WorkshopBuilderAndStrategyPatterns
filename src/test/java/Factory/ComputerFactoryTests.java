package Factory;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class ComputerFactoryTests {
    @Test
    public void testPCCreation() {
        Computer computer = ComputerFactory.getComputer("PC", "32 GB", "1 TB SSD", "Core i9");

        Approvals.verify(computer.toString());
    }

    @Test
    public void testServerCreation(){
        Computer computer = ComputerFactory.getComputer("Server", "64 GB", "4 x 4 TB SSD", "Xeon i9");

        Approvals.verify(computer.toString());

    }

    @Test
    @Disabled
    public void testTabletCreation(){
        //  create a tablet that returns a type of iPad with 16 GB of RAM, 32 GB of storage, and an apple M1 chip
    }
}
