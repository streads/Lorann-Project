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

	
	/** The SQL level by id */	
	public static String sqlMapByLevel = "{call getLevel(?)}";

	/** The SQL all level by id */
	public static String sqlAllLevel = "{call getAllLevel()}";
	
	/** The SQL elements by level */
	public static String sqlElementsByLevel = "{call getElement(?)}";
	
	 /** The id column index. */
    private static int    nameColumnIndex    = 1;

    /** The height column index. */
    private static int    heightColumnIndex  = 2;
    
    /** The width column index. */
    private static int    widthColumnIndex  = 3;
	
    /** The identifier column index. */
    private static int    identifierColumnIndex  = 1;
	
    /** The x position column index. */
    private static int    xPositonColumnIndex  = 2;
	
    /** The y position column index. */
    private static int    yPositionColumnIndex  = 3;
	
	/**
     * Gets the level by number.
     *
     * @param id
     *            the id of the level wished
     * @return the level by number
	 * @throws SQLException 
     */
	public static Level getLevelByNumber(int id) throws SQLException {

        final CallableStatement callStatement = prepareCall(sqlMapByLevel);
        Level level= null;
        callStatement.setInt(1, id);
        if (callStatement.execute()) {
            final ResultSet result = callStatement.getResultSet();
            if (result.first()) {
                level = new Level(id, result.getString(nameColumnIndex), result.getInt(widthColumnIndex), result.getInt(heightColumnIndex));
            }
            result.close();
        }
        feedLevel(level);
        return level;
	}
	
	/**
	 * Load the elements of a level stored in the database
	 * @param level
	 * @throws SQLException
	 */
	public static void feedLevel(Level level) throws SQLException {
        final CallableStatement callStatement = prepareCall(sqlElementsByLevel);
        callStatement.setInt(1, level.getId());
        if (callStatement.execute()) {
            final ResultSet result = callStatement.getResultSet();

            for (boolean isResultLeft = result.first(); isResultLeft; isResultLeft = result.next()) {
                level.addElement(result.getString(identifierColumnIndex), result.getInt(xPositonColumnIndex), result.getInt(yPositionColumnIndex));
            }
            result.close();
        }
        
	}
	
	/**
     * Gets the all levels.
     *
     * @return all the level in a List
	   * @throws SQLException 
     */
	public static List<Level> getAllLevel() throws SQLException{
		final ArrayList<Level> level = new ArrayList<Level>();
        final CallableStatement callStatement = prepareCall(sqlAllLevel);
        if (callStatement.execute()) {
            final ResultSet result = callStatement.getResultSet();

            for (boolean isResultLeft = result.first(); isResultLeft; isResultLeft = result.next()) {
                level.add(new Level(result.getString(nameColumnIndex), result.getInt(widthColumnIndex),  result.getInt(heightColumnIndex)));
            }
            result.close();
        }
        return level;
	}
}
