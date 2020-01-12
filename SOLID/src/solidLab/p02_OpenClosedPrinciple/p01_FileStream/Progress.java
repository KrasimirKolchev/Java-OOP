package solidLab.p02_OpenClosedPrinciple.p01_FileStream;

public class Progress {

    int getCurrentPercent(StreamableObject strObj) {
        return strObj.getSent() * 100 / strObj.getLength();
    }
}
