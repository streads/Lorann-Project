package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Level;

/**
 * <h1>The Abstract Class ADataBaseUseDAO.</h1>
 * 
 * @author Hugo RIVAT hugo.rivat@viacesi.fr
 * @version 1.0
 */

public abstract class ADataBaseUseDAO extends AbstractDAO {

	
	/** The SQL map by id */	
	public static String sqlMapByLevel = "{call getLevel(?)}";

	/** The SQL all map by id */
	public static String sqlAllLevel = "{call getAllLevel()}";
	
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
     * Gets the map level by number.
     *
     * @param id
     *            the id of the level wished
     * @return the level by number
     */
	public Map getLevelByNumber(int id) {
        final CallableStatement callStatement = prepareCall(sqlMapByLevel);
        Level level= null;
        callStatement.setInt(1, id);
        if (callStatement.execute()) {
            final ResultSet result = callStatement.getResultSet();
            if (result.first()) {
                level = new Level(result.getString(nameColumnIndex), result.getInt(heightColumnIndex), result.getInt(widthColumnIndex));
            }
            result.close();
        }
        feedMap(level);
        return level;
        
        
        return null;
	}
	
	public void feedLevel(Level level) {
        final CallableStatement callStatement = prepareCall(sqlAllLevel);
        if (callStatement.execute()) {
            final ResultSet result = callStatement.getResultSet();

            for (boolean isResultLeft = result.first(); isResultLeft; isResultLeft = result.next()) {
                map.addElement(result.getString(identifierColumnIndex), result.getInt(xPositonColumnIndex), result.getInt(yPositionColumnIndex));
            }
            result.close();
        }
        
	}
	
	/**
     * Gets the all levels.
     *
     * @return all the level in a List
     */
	public List<Level> getAllLevel(){
		final ArrayList<Level> level = new ArrayList<Level>();
        final CallableStatement callStatement = prepareCall(sqlAllLevel);
        if (callStatement.execute()) {
            final ResultSet result = callStatement.getResultSet();

            for (boolean isResultLeft = result.first(); isResultLeft; isResultLeft = result.next()) {
                level.add(new Level(result.getString(nameColumnIndex), result.getInt(heightColumnIndex), result.getInt(widthColumnIndex)));
            }
            result.close();
        }
        return level;
		return null;
	}

	

}
