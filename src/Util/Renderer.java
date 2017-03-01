package Util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class Renderer extends JLabel implements TableCellRenderer {
    protected Font tipoLetraTextoSeleccionado;
    protected Color colorTextoSeleccionado;
    protected Color colorFondoSeleccionado;
    protected Font tipoLetraTextoNoSeleccionado;
    protected Color colorTextoNoSeleccionado;
    protected Color colorFondoNoSeleccionado;
    protected int alineacion;
    protected String formato;

    public Renderer(Font tipoLetraTextoSeleccionado, Color colorTextoSeleccionado, Color colorFondoSeleccionado, Font tipoLetraTextoNoSeleccionado, Color colorTextoNoSeleccionado, Color colorFondoNoSeleccionado, int alineacion, String formato){
        this.tipoLetraTextoSeleccionado = tipoLetraTextoSeleccionado;
        this.colorTextoSeleccionado = colorTextoSeleccionado;
        this.colorFondoSeleccionado = colorFondoSeleccionado;
        this.tipoLetraTextoNoSeleccionado = tipoLetraTextoNoSeleccionado;
        this.colorTextoNoSeleccionado = colorTextoNoSeleccionado;
        this.colorFondoNoSeleccionado = colorFondoNoSeleccionado;
        this.alineacion = alineacion;
        this.formato = formato;
    }

    public void setEstilo(Font tipoLetraTextoSeleccionado, Color colorTextoSeleccionado, Color colorFondoSeleccionado, Font tipoLetraTextoNoSeleccionado, Color colorTextoNoSeleccionado, Color colorFondoNoSeleccionado, int alineacion, String formato) {
        this.tipoLetraTextoSeleccionado = tipoLetraTextoSeleccionado;
        this.colorTextoSeleccionado = colorTextoSeleccionado;
        this.colorFondoSeleccionado = colorFondoSeleccionado;
        this.tipoLetraTextoNoSeleccionado = tipoLetraTextoNoSeleccionado;
        this.colorTextoNoSeleccionado = colorTextoNoSeleccionado;
        this.colorFondoNoSeleccionado = colorFondoNoSeleccionado;
        this.alineacion = alineacion;
        this.formato = formato;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component componente;

        this.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        if(!formato.equals("Logico")) {
            if(formato.equals("Cadena")) {
                this.setText(value == null?"":value.toString());
            }
            else if (formato.equals("Imagen")) {
                if(value == null) {
                    this.setText("");
                }
                else {
                    this.setIcon(new ImageIcon(getClass().getResource("/Iconos/" + value.toString() + ".png")));
                }
            }

            setHorizontalAlignment(alineacion);
            setOpaque(true);

            if (isSelected) {
                setFont(tipoLetraTextoSeleccionado);
                setForeground(colorTextoSeleccionado);
                setBackground(colorFondoSeleccionado);
            }
            else {
                setFont(tipoLetraTextoNoSeleccionado);
                setForeground(colorTextoNoSeleccionado);
                setBackground(colorFondoNoSeleccionado);
            }

            componente = this;
        }
        else {
            if(value == null) {
                this.setText("");

                componente = this;
            }
            else {
                JCheckBox checkBox = new JCheckBox();

                checkBox.setSelected(Boolean.parseBoolean(value.toString()));
                checkBox.setHorizontalAlignment(alineacion);
                checkBox.setOpaque(true);

                if (isSelected) {
                    checkBox.setBackground(colorFondoSeleccionado);
                }
                else {
                    checkBox.setBackground(colorFondoNoSeleccionado);
                }

                componente = checkBox;
            }
        }

        return componente;
    }
}