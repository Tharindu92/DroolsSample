package com.test_rules.ariot_rules;

public class CouchDBRead {
	private CouchDBConnection couchDBConnection;
    private Database db;

    public CouchDBRead(){
        try {
            couchDBConnection = new CouchDBConnection();
            db = couchDBConnection.getDatabase();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
