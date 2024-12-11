import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class Divisa {

    @SerializedName("base_code")
    private String base_code;
    @SerializedName("time_last_update_utc")
    private String time_last_update_utc;
    @SerializedName("conversion_rates")
    private Map<String, Double> conversion_rates;

    public String getBase_code() {
        return this.base_code;
    }

    public void setBaseCurrency(String base_code) {
        this.base_code = base_code;
    }

    public String getTime_last_update_utc() {
        return this.time_last_update_utc;
    }

    public Map<String, Double> getConversion_rates() {
        return this.conversion_rates;
    }

    public String toString() {
        return "Divisa{baseCurrency='" + this.base_code + "', date='" + this.time_last_update_utc + "', rates=" + this.conversion_rates + "}";
    }
}
