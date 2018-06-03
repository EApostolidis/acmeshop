package gr.codehub.teamb.acmeshop.dto;

public class ErrorMessage {
    public ErrorMessage(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    private int code;

}

