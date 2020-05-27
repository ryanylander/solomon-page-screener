package solution;

import lombok.Data;

@Data
public class DateInterval {

    private int eff;
    private int term;

    public DateInterval(int start, int end) {
        this.eff = start;
        this.term = end;
    }

    public int length() {
        return term - eff;
    }
    
}