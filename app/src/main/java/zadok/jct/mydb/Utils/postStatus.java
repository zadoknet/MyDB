package zadok.jct.mydb.Utils;

public class postStatus {
    public enum savingStatus {NOT_DEFINE,SUCCESS,FAILED}
    private savingStatus status;

    public savingStatus getStatus() {
        return status;
    }

    public void setStatus(savingStatus status) {
        this.status = status;
    }
    public postStatus(savingStatus _status)
    {
        status=_status;
    }
}
