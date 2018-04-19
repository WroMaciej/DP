package wromaciej.hvac_sim.ids;


import java.util.concurrent.atomic.AtomicInteger;

public class Ids implements IdGenerator {

    private AtomicInteger maximalId;

    @Override
    public int getUniqueId(){
        return maximalId.incrementAndGet();
    }

    public Ids() {
        maximalId = new AtomicInteger();
    }

}
