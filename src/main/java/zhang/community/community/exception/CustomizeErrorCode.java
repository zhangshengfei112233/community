package zhang.community.community.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode {
    QUESTION_NOT_FOUND(2001, "你找的问题不在了，要不然换个试试？"),
    TARGET_PARAM_NOT_FOUND(2001, "未选中任何问题或评论进行回复"),
    NO_LOGIN(2003, "未登录不能进行评论，请先登陆"),
    SYS_ERROR(2004, "服务器冒烟了，要不等会再试试？");

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    CustomizeErrorCode(String message) {
        this.message = message;
    }

    private Integer code;
    private String message;

    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }


}
