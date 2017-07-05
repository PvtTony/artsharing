package me.songt.artsharing.vo;

/**
 * Created by tony on 2017/6/27.
 */
public class Result
{
    private boolean isSuccess;
    private String info;
    private Object infoObject;

    public Result(boolean isSuccess, String info)
    {
        this.info = info;
    }

    public Result(boolean isSuccess, String info, Object infoObject)
    {
        this.info = info;
        this.infoObject = infoObject;
    }

    public boolean isSuccess()
    {
        return isSuccess;
    }

    public void setSuccess(boolean success)
    {
        isSuccess = success;
    }

    public String getInfo()
    {
        return info;
    }

    public void setInfo(String info)
    {
        this.info = info;
    }

    public Object getInfoObject()
    {
        return infoObject;
    }

    public void setInfoObject(Object infoObject)
    {
        this.infoObject = infoObject;
    }


}
