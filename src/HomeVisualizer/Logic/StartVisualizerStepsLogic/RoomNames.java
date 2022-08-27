package HomeVisualizer.Logic.StartVisualizerStepsLogic;

import java.util.ArrayList;
import java.util.List;

public class RoomNames {
    
    private String name;
    private List<Integer> wallNames = new ArrayList<>();

    public RoomNames(String name, List<Integer> wallNames2) {
        this.name = name;
        this.wallNames = wallNames2;
    }

    public String getName() {
        return this.name;
    }

    public List<Integer> getWallNames() {
        return this.wallNames;
    }
}