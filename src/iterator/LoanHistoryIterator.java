package iterator;

import java.util.List;
import model.Loan;

public class LoanHistoryIterator implements Iterator {

    private List<Loan> loans;
    private int index = 0;

    public LoanHistoryIterator(List<Loan> loans) {
        this.loans = loans;
    }

    @Override
    public boolean hasNext() {
        return index < loans.size();
    }

    @Override
    public Object next() {
        return loans.get(index++);
    }
}