package kr.koreait.memoProjectWin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MainClass extends JFrame implements ActionListener{
	
	// JTable의 열 이름으로 사용할 내용이 저장된 배열을 선언한다. 
	String[] colName = {"번호","이름","비밀번호","메모","작성일"};
	
	// DefaultTableModel 클래스 객체를 사용해 JTable의 열 이름을 넣어주고 화면에 표시될 행 수를 지정한다.
	// DefaultTableModel(열 이름이 저장된 배열, 화면에 보여질 행의 개수) 
	DefaultTableModel model = new DefaultTableModel(colName, 0);
	// JTable 객체는 DefaultTableModel 클래스 객체로 생성한 JTable 모델의 생성자의 인수로 넘겨서 만든다.
	JTable table = new JTable(model);
	
	JPanel controlPanel = new JPanel(new BorderLayout());
	JPanel dataPanel = new JPanel(new BorderLayout());
	JPanel buttonPanel = new JPanel(new GridLayout(1, 4));
	JPanel labelPanel = new JPanel(new GridLayout(3, 1));
	JPanel fieldPanel = new JPanel(new GridLayout(3, 1));
	
	JLabel nameLabel = new JLabel("이름");
	JLabel passwordLabel = new JLabel("비밀번호");
	JLabel memoLabel = new JLabel("메모");
	
	JTextField nameField = new JTextField(20);
	JTextField passwordField = new JTextField(20);
	JTextField memoField = new JTextField(500);
	
	JButton button1 = new JButton("입력");
	JButton button2 = new JButton("보기");
	JButton button3 = new JButton("수정");
	JButton button4 = new JButton("삭제");
	
	int sRow;
	Object sNo;
	Object sName;
	Object sPassword;
	Object sMemo;
	
	int no;
	String pw;
	String me;	
	
	public MainClass(){
		
		// 윈도우에 JTable을 그냥 넣으면 안보인다. ==> 제목 행과 스크롤바를 표시해야 한다.
		// 생성하고 생성자의 인수로 JTable 객체를 넘겨 생성한 JScrollPane 클래스의 객체를 윈도우에 넣어주어야 한다. 
		
		JScrollPane jsp = new JScrollPane(table);
		add(jsp);
		
		table.setGridColor(Color.BLUE); // JTable의 선 색상을 변경한다.
		table.setBackground(Color.YELLOW); // JTable의 배경 색상을 변경한다.
		table.setRowHeight(20); // JTable의 행 높이를 변경한다.
	
		setTitle("JTable Test");
		setBounds(800, 50, 500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		controlPanel.setPreferredSize(new Dimension(500, 180));
		add(controlPanel, BorderLayout.SOUTH);
		
		labelPanel.setPreferredSize(new Dimension(100, 80));
		labelPanel.add(nameLabel);
		labelPanel.add(passwordLabel);
		labelPanel.add(memoLabel);
		
		fieldPanel.add(nameField);
		fieldPanel.add(passwordField);
		fieldPanel.add(memoField);
		
		dataPanel.setPreferredSize(new Dimension(500, 160));
		dataPanel.add(labelPanel, BorderLayout.WEST);
		dataPanel.add(fieldPanel);		
		controlPanel.add(dataPanel, BorderLayout.NORTH);
		
		buttonPanel.setPreferredSize(new Dimension(500, 20));
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		buttonPanel.add(button1);
		buttonPanel.add(button2);
		buttonPanel.add(button3);
		buttonPanel.add(button4);
		controlPanel.add(buttonPanel, BorderLayout.SOUTH);
		
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				sRow = table.getSelectedRow();
				sNo = table.getValueAt(sRow, 0);
				sName = table.getValueAt(sRow, 1);
				sPassword = table.getValueAt(sRow, 2);
				sMemo = table.getValueAt(sRow, 3);
				
				nameField.setText(sName + "");
				passwordField.setText("");
				memoField.setText(sMemo + "");
			}			
		});
		
		setVisible(true);
	}	
	
	public static void main(String[] args) {
		MainClass frame = new MainClass();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "입력" :
			// 텍스트 필드에 입력된 데이터를 받아서 테이블에 저장하는 DAO 클래스의 메소드를 호출한다.
			String name = nameField.getText().trim();
			String password = passwordField.getText().trim();
			String memo = memoField.getText().trim();
			MemoDAO.insert(name, password, memo);
			nameField.setText("");
			passwordField.setText("");
			memoField.setText("");
			nameField.requestFocus();
			break;
		case "보기" :
			ResultSet rs = MemoDAO.select();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm:ss");
			
			// JTable에 값을 넣어주기 전에 기존에 저장되 데이터를 지워주지 않으면 기존 데이터 뒤에 새로
			// 들어가는 데이터가 추가되어 보인다 ==> 지울때는 맨 마지막 데이터부터 제거 한다.
			
			for(int i=model.getRowCount()-1; i>=0; i--){
				// removeRow(index) : JTable을 구성하는 모델 객체에 저장된 index번째 데이터를 제거한다.
				model.removeRow(i);
			}			
			
			try {
				if(rs.next()){
					// 테이블에서 얻어온 데이터를 JTable에 출력한다.
					// 테이블의 필드가 5개이므로 5개짜리 문자열 배열을 만든다.
					String[] row = new String[5];
					do{
						row[0] = rs.getInt("idx") + "";
						row[1] = rs.getString("name");
						row[2] = rs.getString("password");
						row[3] = rs.getString("memo");
						row[4] = sdf.format(rs.getDate("writeDate"));
						
						// JTable에 넣어준다.
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
			break;
		case "수정" :
			no = Integer.parseInt(sNo + "");
			pw = passwordField.getText().trim();
			me = memoField.getText();
			if(pw.equals("")){
				JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요.");
			}
			else{
				MemoDAO.update(no,pw,me);
				nameField.setText("");
				passwordField.setText("");
				memoField.setText("");
				nameField.requestFocus();
			}			
			break;
		case "삭제" :
			no = Integer.parseInt(sNo + "");
			pw = passwordField.getText().trim();
			if(pw.equals("")){
				JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요.");
			}
			else{
				MemoDAO.delete(no,pw);
				nameField.setText("");
				passwordField.setText("");
				memoField.setText("");
				nameField.requestFocus();
			}			
			break;
		}
		
	}
	
}
