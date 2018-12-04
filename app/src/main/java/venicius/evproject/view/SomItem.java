package venicius.evproject.view;

public class SomItem {
    private int mSomName;
    private int mFlagImage;

    public SomItem(int somName, int flagImage) {
        mSomName = somName;
        mFlagImage = flagImage;
    }

    public int getSomName() {
        return mSomName;
    }

    public int getFlagImage() {
        return mFlagImage;
    }
}
