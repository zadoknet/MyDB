package zadok.jct.mydb.Utils;

public class PostStatus {
    public enum savingStatus {NOT_DEFINE,SUCCESS,FAILED}
    private savingStatus status;

    public savingStatus getStatus() {
        return status;
    }

    public void setStatus(savingStatus status) {
        this.status = status;
    }
    public PostStatus(savingStatus _status)
    {
        status=_status;
    }
}
