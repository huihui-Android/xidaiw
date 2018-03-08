package xidaiw.licai.bean;

import java.util.ArrayList;

/**
 * Created by admin on 2018/2/5.
 */

public class LoanResults {
    private ArrayList<Loan> loanDatas;
    private ArrayList<Loan1> loanDatas1;
    private ArrayList<Loan2> loanDatas2;
    private int total;

    public ArrayList<Loan1> getLoanDatas1() {
        return loanDatas1;
    }

    public void setLoanDatas1(ArrayList<Loan1> loanDatas1) {
        this.loanDatas1 = loanDatas1;
    }

    public ArrayList<Loan2> getLoanDatas2() {
        return loanDatas2;
    }

    public void setLoanDatas2(ArrayList<Loan2> loanDatas2) {
        this.loanDatas2 = loanDatas2;
    }

    public ArrayList<Loan> getLoanDatas() {
        return loanDatas;
    }

    public void setLoanDatas(ArrayList<Loan> loanDatas) {
        this.loanDatas = loanDatas;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
