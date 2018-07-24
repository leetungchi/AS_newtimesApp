package exgui.ultratable;

public class CellRenderor4Amount extends javax.swing.JLabel
  implements javax.swing.table.TableCellRenderer{
  java.text.NumberFormat nf=new java.text.DecimalFormat("##########0.00");
  public CellRenderor4Amount(){
  super();
 //setBorder(javax.swing.BorderFactory.createRaisedBevelBorder());
 setOpaque(true); /* it\u00B4s essential */
 setHorizontalAlignment(super.RIGHT);
}
public java.awt.Component getTableCellRendererComponent(
     javax.swing.JTable table, Object value,
     boolean isSelected, boolean hasFocus,
     int row, int column){

    String text = (value==null)?"":value.toString().trim();
    if(!text.equals("")) text=nf.format(Double.parseDouble(text));
    setBackground(new java.awt.Color(0xFF, 0xFF, 0xFF)); // Decides the color
    if(isSelected)setBackground(new java.awt.Color(0xFF, 0xE3, 0x8C));
    setText(text);
 return this;
}
}
