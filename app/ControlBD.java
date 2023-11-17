import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class ControlBD {
    private Context context;
    private DataBase dbHelper;
    private SQLiteDatabase database;

    public ControlBD(Context context) {
        this.context = context;
    }

    public ControlBD open() throws SQLException {
        dbHelper = new DataBase(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public long insertReserva(String nombreApellido, String telefono, String hora) {
        ContentValues values = new ContentValues();
        values.put("nombre_apellido", nombreApellido);
        values.put("telefono", telefono);
        values.put("hora", hora);
        return database.insert("Reservas", null, values);
    }

    public Cursor getAllReservas() {
        return database.query("Reservas", null, null, null, null, null, null);
    }

    public int updateReserva(long id, String nombreApellido, String telefono, String hora) {
        ContentValues values = new ContentValues();
        values.put("nombre_apellido", nombreApellido);
        values.put("telefono", telefono);
        values.put("hora", hora);
        return database.update("Reservas", values, "id=" + id, null);
    }

    public void deleteReserva(long id) {
        database.delete("Reservas", "id=" + id, null);
    }
}

