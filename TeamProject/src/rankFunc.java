import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class rankFunc extends DefaultTableCellRenderer {
    static String[] colName = {"순위","닉네임","점수"};
    static DefaultTableModel model;
    static JTable table;
    static JPanel panel = new JPanel();
    
    static int rank = 1;
    
    
    public static void rank(){
       JFrame frame = new JFrame("랭킹");         
       frame.setBounds(800,50,500,500);
       frame.getDefaultCloseOperation();
       frame.setVisible(true);
       
       panel.removeAll();
       
       model = new DefaultTableModel(colName, 0) {
          /* JTable 클릭시 수정안되게 하는 메소드 */
          public boolean isCellEditable(int i, int c) {
             return false;
          }
          
       };
       
       table = new JTable(model) {
         /* 테이블의 특정 위치 색 변경 */
         public Component prepareRenderer(TableCellRenderer tcr, int row, int column) {
            Component c = super.prepareRenderer(tcr, row, column);
             if(isRowSelected(row)) {
                c.setForeground(getSelectionForeground());
                c.setBackground(getSelectionBackground());
             }else{
                c.setForeground(getForeground());
                if( (row == 0) || (row == 1) || (row == 2) ){
                   c.setFont(new Font("굴림", Font.BOLD, 13));
                } else {
                      c.setFont(new Font("굴림", Font.PLAIN, 13));
                }
                   c.setBackground(new Color(204, 255, 255, 70));
             }
             
             return c;
            }
       };
       
       JScrollPane jsp = new JScrollPane(table);  
       jsp.getViewport().setBackground(new Color(255, 255, 255, 100));
       TitledBorder titleB = new TitledBorder(new LineBorder(Color.black), "Ranking");
       titleB.setTitleColor(new Color(98, 148, 255));
       panel.setBorder(titleB);
       panel.setBackground(new Color(170, 214, 252));
       panel.add(jsp);
       frame.add(panel);
       
       String sql4 = "select * from game order by score desc";
         
      try {
         Connection conn = DBUtil.getMySQLConnection();
         PreparedStatement pstmt4 = conn.prepareStatement(sql4);
         ResultSet rs = pstmt4.executeQuery();
         
         for(int i=model.getRowCount()-1; i>=0; i--){
            model.removeRow(i);
         }
         
         try {
            if(rs.next()){
               String[] row = new String[3];
               do{
                  row[0] = rank++ + "";
                  row[1] = rs.getString("nickname");
                  row[2] = String.format("%5.2f", rs.getDouble("score")) ;            
                  model.addRow(row);
               }while(rs.next());
            }
            else{
               JOptionPane.showMessageDialog(null, "데이터가 없습니다.");
            }
         } catch (SQLException e1) {
            e1.printStackTrace();
         } catch (HeadlessException e1) {
            e1.printStackTrace();
         }
            
      } catch (SQLException e1) {
         e1.printStackTrace();
      }

      
      
    }
    
}