package venicius.evproject;

public class FundoItem {


        private String mFundoName;
        private int mFlagImage;

        public FundoItem(String fundoName, int flagImage) {
            mFundoName = fundoName;
            mFlagImage = flagImage;
        }

        public String getFundoName() {
            return mFundoName;
        }

        public int getFlagImage() {
            return mFlagImage;
        }
    }

