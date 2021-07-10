package day3.spring.domain;

public class AjaxResult {
    private String msg;
    private Long code;
    private String welcome;

    public AjaxResult(String msg, Long code) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }
}
