package packag.jk.com.mobileshop;

public class model {
    String model_color;
    String second_model_color;
    String third_model_color;
    String four_model_color;
    String five_model_color;

    public model(){}

    public model(String model_color, String second_model_color, String third_model_color,
                 String four_model_color,String five_model_color) {
        this.model_color = model_color;
        this.second_model_color = second_model_color;
        this.third_model_color = third_model_color;
        this.four_model_color = four_model_color;
        this.five_model_color = five_model_color;
    }

    public String getModel_color() {
        return model_color;
    }

    public String getSecond_model_color() {
        return second_model_color;
    }

    public String getThird_model_color() {
        return third_model_color;
    }

    public String getFour_model_color() {
        return four_model_color;
    }

    public String getFive_model_color() {
        return five_model_color;
    }
}

