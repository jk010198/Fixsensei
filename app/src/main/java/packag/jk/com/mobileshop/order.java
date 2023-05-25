package packag.jk.com.mobileshop;

public class order {

    String id;
    String device_name;
    String model_name;
    String issue;
    String date;
    String name;
    String model_color;
    String email;
    String phn;
    String alt_phn;
    String add;
    String remark;

    public order(){}

    public order(String id, String device_name, String model_name, String issue, String date, String name,String model_color,
                 String email, String phn, String alt_phn, String add, String remark) {
        this.id = id;
        this.device_name = device_name;
        this.model_name = model_name;
        this.issue = issue;
        this.date = date;
        this.name = name;
        this.model_color = model_color;
        this.email = email;
        this.phn = phn;
        this.alt_phn = alt_phn;
        this.add = add;
        this.remark = remark;
    }

    public String getId() {
        return id;
    }

    public String getDevice_name() {
        return device_name;
    }

    public String getModel_name() {
        return model_name;
    }

    public String getIssue() {
        return issue;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getModel_color() {
        return model_color;
    }

    public String getEmail() {
        return email;
    }

    public String getPhn() {
        return phn;
    }

    public String getAlt_phn() {
        return alt_phn;
    }

    public String getAdd() {
        return add;
    }

    public String getRemark() {
        return remark;
    }
}
