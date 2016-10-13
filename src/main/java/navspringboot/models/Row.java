package navspringboot.models;

public class Row {
    private String objecttype;
    private String modulename;
    private String versionname;
    private String read;
    private String insert;
    private String modify;
    private String delete;
    private String execute;
    private String productline;

    public Row(String objecttype, String modulename, String versionname, String read, String insert, String modify, String delete, String execute, String productline) {
        this.objecttype = objecttype;
        this.modulename = modulename;
        this.versionname = versionname;
        this.read = read;
        this.insert = insert;
        this.modify = modify;
        this.delete = delete;
        this.execute = execute;
        this.productline = productline;
    }

    public String getObjecttype() {
        return objecttype;
    }

    public void setObjecttype(String objecttype) {
        this.objecttype = objecttype;
    }

    public String getModulename() {
        return modulename;
    }

    public void setModulename(String modulename) {
        this.modulename = modulename;
    }

    public String getVersionname() {
        return versionname;
    }

    public void setVersionname(String versionname) {
        this.versionname = versionname;
    }

    public String getRead() {
        return read;
    }

    public void setRead(String read) {
        this.read = read;
    }

    public String getInsert() {
        return insert;
    }

    public void setInsert(String insert) {
        this.insert = insert;
    }

    public String getModify() {
        return modify;
    }

    public void setModify(String modify) {
        this.modify = modify;
    }

    public String getDelete() {
        return delete;
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }

    public String getExecute() {
        return execute;
    }

    public void setExecute(String execute) {
        this.execute = execute;
    }

    public String getProductline() {
        return productline;
    }

    public void setProductline(String productline) {
        this.productline = productline;
    }

} // class Row
