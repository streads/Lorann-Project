package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Map;

/**
 * <h1>The Abstract Class ADataBaseUseDAO.</h1>
 * 
 * @author Hugo RIVAT hugo.rivat@viacesi.fr
 * @version 1.0
 */

public abstract class ADataBaseUseDAO extends AbstractDAO {

	
	/** The SQL map by id */	
	public static String sqlMapByLevel = "{call getMap(?)}";

	/** The SQL all map by id */
	public static String sqlAllMap = "{call getAllMap()}";
	
	/** The SQL elements by level */
	public static String sqlElementsByLevel = "{call getElement(?)}";
	
	 /** The id column index. */
    private static int    nameColumnIndex    = 0;

    /** The name column index. */
    private static int    heightColumnIndex  = 1;
    
    /** The name column index. */
    private static int    widthColumnIndex  = 2;
	
    /** The name column index. */
    private static int    identifierColumnIndex  = 0;
	
    /** The name column index. */
    private static int    xPositonColumnIndex  = 1;
	
    /** The name column index. */
    private static int    yPositionColumnIndex  = 2;
	
	/**
     * Gets the map level by id.
     *
     * @param id
     *            the id of the map wished
     * @return the map by id
     */
	public Map getMapByLevel(int id) {
        final CallableStatement callStatement = prepareCall(sqlMapByLevel);
        Map map = null;
        callStatement.setInt(1, id);
        if (callStatement.execute()) {
            final ResultSet result = callStatement.getResultSet();
            if (result.first()) {
                map = new Map(result.getString(nameColumnIndex), result.getInt(heightColumnIndex), result.getInt(widthColumnIndex));
            }
            result.close();
        }
        feedMap(map);
        return map;
        
        
        return null;
	}
	
	public void feedMap(Map map) {
        final CallableStatement callStatement = prepareCall(sqlAllMap);
        if (callStatement.execute()) {
            final ResultSet result = callStatement.getResultSet();

            for (boolean isResultLeft = result.first(); isResultLeft; isResultLeft = result.next()) {
                map.addElement(result.getString(identifierColumnIndex), result.getInt(xPositonColumnIndex), result.getInt(yPositionColumnIndex));
            }
            result.close();
        }
        
	}
	
	/**
     * Gets the all maps.
     *
     * @return all the maps in a List
     */
	public List<Map> getAllMap(){
		final ArrayList<Map> map = new ArrayList<Map>();
        final CallableStatement callStatement = prepareCall(sqlAllMap);
        if (callStatement.execute()) {
            final ResultSet result = callStatement.getResultSet();

            for (boolean isResultLeft = result.first(); isResultLeft; isResultLeft = result.next()) {
                map.add(new Map(result.getString(nameColumnIndex), result.getInt(heightColumnIndex), result.getInt(widthColumnIndex)));
            }
            result.close();
        }
        return map;
		return null;
	}

	

}
