/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.reservasvuelo.data;

/**
 *
 * @author 2dawb
 */
class DataBaseConfig {
    
      private static final int DEFAULT_DB_PAGESIZE = 20;
    
    private String driverClassName;
    private String databaseUrl;
    private String databaseUser;
    private String databasePassword;
    private Integer databasePageSize;

    public DataBaseConfig() {
    }

    public DataBaseConfig(String driverClassName, String databaseUrl, String databaseUser, String databasePassword) {
        this.driverClassName = driverClassName;
        this.databaseUrl = databaseUrl;
        this.databaseUser = databaseUser;
        this.databasePassword = databasePassword;
        this.databasePageSize = DEFAULT_DB_PAGESIZE;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public void setDatabaseUrl(String databaseUrl) {
        this.databaseUrl = databaseUrl;
    }

    public String getDatabaseUser() {
        return databaseUser;
    }

    public void setDatabaseUser(String databaseUser) {
        this.databaseUser = databaseUser;
    }

    public String getDatabasePassword() {
        return databasePassword;
    }

    public void setDatabasePassword(String databasePassword) {
        this.databasePassword = databasePassword;
    }

    public Integer getDatabasePageSize() {
        return databasePageSize;
    }

    public void setDatabasePageSize(Integer databasePageSize) {
        this.databasePageSize = databasePageSize;
    }

    void setDatabasePageSize(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setDataBaseUrl(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setDataBaseUser(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setDataBasePassword(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
      
    
}
