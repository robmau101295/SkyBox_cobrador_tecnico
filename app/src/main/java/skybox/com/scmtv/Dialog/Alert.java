package skybox.com.scmtv.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import skybox.com.scmtv.R;

public class Alert extends Dialog {

    private String message;
    private int Imagen=0;
  //  private int icon=0;
    private View.OnClickListener btYesListener=null;

    public Alert(Context context) {
        super(context);
    }

    public Alert(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected Alert(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialogo_personalizado);
        TextView tv = (TextView) findViewById(R.id.textViewCustomDialog);
        ImageView vista_general = (ImageView) findViewById(R.id.imageViewVistaGeneral);
        Button boton_cerrar = (Button) findViewById(R.id.boton_confirmacion);

        vista_general.setImageResource(getImagen());
        tv.setText(getMessage());
        boton_cerrar.setOnClickListener(btYesListener);

    }

    public int getImagen() {
        return Imagen;
    }

    public void setImagen(int imagen) {
        Imagen = imagen;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPositveButton(View.OnClickListener onClickListener) {
        dismiss();
        this.btYesListener = onClickListener;


    }

}