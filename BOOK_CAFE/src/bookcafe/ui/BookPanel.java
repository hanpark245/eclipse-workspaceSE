package bookcafe.ui;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import bookcafe.book.Book;
import bookcafe.book.BookService;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BookPanel extends JPanel {
	private JTextField searchTF;
	private JTable table;
	private DefaultTableModel tableModel;
    private int no;
    public BookService bookSV;
	public String[][] dataStr;
	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public BookPanel() throws Exception {
		setLayout(null);
		
		
		
		
		/* sm add */
		// data 관련 처리		
		bookSV = new BookService();
		ArrayList<Book> tempBooks = bookSV.allViewBook();
				
		String header[] = {"no","제목","작가","위치","재고"};
		dataStr = new String[tempBooks.size()][5];
		
		for (int i = 0; i < tempBooks.size(); i++) {
			Book tBooks = tempBooks.get(i);
			dataStr[i][0] = tBooks.getBook_no() + "";
			dataStr[i][1] = tBooks.getBook_name();
			dataStr[i][2] = tBooks.getBook_author();
			dataStr[i][3] = tBooks.getBook_pos();
			dataStr[i][4] = tBooks.getBook_stock() + "";
		}
		/* sm add end */
		
		JComboBox searchCB = new JComboBox();
		searchCB.setModel(new DefaultComboBoxModel(new String[] {"\uB3C4\uC11C\uBA85", "\uC791\uAC00\uBA85"}));
		searchCB.setBounds(258, 23, 70, 21);
		add(searchCB);
		
		searchTF = new JTextField();
		searchTF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int choiceNum = searchCB.getSelectedIndex();
				switch (choiceNum) {
				case 0:						
					if(e.getKeyCode()==KeyEvent.VK_ENTER){
						try {
							BookPanel.this.enterPress();
							searchTF.setText("");
						} catch (Exception e1) {
							e1.printStackTrace();
						}}
					  break;
				case 1:
					if(e.getKeyCode()==KeyEvent.VK_ENTER){
						try {
							BookPanel.this.booknana();
							searchTF.setText("");
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					break;
					}
				
				
					}
			}
			public void keyReleased(KeyEvent e){}
			public void keyTyped(KeyEvent e){}
		});
		searchTF.setBounds(341, 23, 116, 21);
		add(searchTF);
		searchTF.setColumns(20);
		
		/* sm add */
		// searchBTN (검색버튼)
		JButton searchBTN = new JButton("\uAC80\uC0C9");
		searchBTN.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e) {
				try {
					int choiceNum = searchCB.getSelectedIndex();
					ArrayList<Book> tempBook = new ArrayList<Book>();
					
					switch (choiceNum) {
					case 0:						
							tempBook = bookSV.searchBook(searchTF.getText());						
						break;
					case 1:
						tempBook = bookSV.searchAuhor(searchTF.getText());
						break;
					}
					
					/*for (Book book : tempBook) {
						System.out.println(book.toString());
					}*/
					//System.out.println("tempbook:"+tempBooks.size());
					dataStr = new String[tempBook.size()][5];
					
					for (int i = 0; i < tempBook.size(); i++) {
						Book tBooks = tempBook.get(i);
						dataStr[i][0] = tBooks.getBook_no() + "";
						dataStr[i][1] = tBooks.getBook_name();
						dataStr[i][2] = tBooks.getBook_author();
						dataStr[i][3] = tBooks.getBook_pos();
						dataStr[i][4] = tBooks.getBook_stock() + "";
					}
					/* sm edit */
					/*for (int i = 0; i < tempBook.size(); i++) {	
						for (int j = 0; j < 4; j++) {
							System.out.println(dataStr[i][j]);
						}
					}*/
					tableModel = new DefaultTableModel(dataStr, header);
					//tableModer = new Def
					//table.updateUI();
					table.setModel(tableModel);
					table.getColumnModel().getColumn(1).setPreferredWidth(288);
					table.getColumnModel().getColumn(2).setPreferredWidth(114);
					for (int i = 0; i < dataStr.length; i++) {
						table.getColumnModel().getColumn(i).setResizable(false);
					}
					/* sm edit end */
					//table.setModel(new DefaultTableModel(dataStr,header);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		/* sm add end */
		
		searchBTN.setBounds(468, 22, 97, 23);
		add(searchBTN);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(73, 70, 680, 337);
		add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(dataStr,header) {	// sm edit
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(288);
		table.getColumnModel().getColumn(2).setPreferredWidth(114);
		for (int i = 0; i < header.length; i++) {
			table.getColumnModel().getColumn(i).setResizable(false);
		}
		
		/* sm add */
		table.setAutoCreateRowSorter(true);
		TableRowSorter Tsorter = new TableRowSorter(table.getModel());
		table.setRowSorter(Tsorter);
		/* sm add end */
		
		scrollPane.setViewportView(table);
		
	 
	
		
		
		//전체보기 버튼
		JButton listViewBTN = new JButton("\uC804\uCCB4 \uBCF4\uAE30");
		listViewBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					seeAllClick();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}


		
		});
		
	      
		
		listViewBTN.setBounds(73, 430, 97, 23);
		add(listViewBTN);
		
		JButton addBTN = new JButton("\uCD94\uAC00");
		addBTN.addActionListener(new ActionListener() {
			//추가 버튼
			public void actionPerformed(ActionEvent e) {
				BookAddModifyDialog addB;
				try {
					addB = new BookAddModifyDialog(BookPanel.this);
					addB.setModal(true);
					addB.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
					addB.setVisible(true);
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		addBTN.setBounds(493, 430, 80, 23);
		add(addBTN);
		
		
		//수정버튼
		JButton modifyBTN = new JButton("\uC218\uC815");
		modifyBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int choiceRow = table.getSelectedRow();
			no = Integer.parseInt((String)table.getValueAt(choiceRow, 0));	
			BookEditModifyDialog addB;
			try {
				
				addB = new BookEditModifyDialog(BookPanel.this);
				bookSV.updatBook(new Book());
				addB.setModal(true);
				addB.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
				addB.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			
			}
		});
		modifyBTN.setBounds(583, 430, 80, 23);
		add(modifyBTN);
		
		
		//삭제버튼
		JButton delBTN = new JButton("\uC0AD\uC81C");
		delBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choiceRow = table.getSelectedRow();
				int no = Integer.parseInt((String)table.getValueAt(choiceRow, 0));
				
				try {
					bookSV.delBook(no);
					seeAllClick();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		delBTN.setBounds(673, 430, 80, 23);
		add(delBTN);

	}
	
	
	

	
	public void seeAllClick () throws Exception {
		BookService bookSV = new BookService();
		ArrayList<Book> tempBooks = bookSV.allViewBook();
				
		String header[] = {"no","제목","작가","위치","재고"};
		dataStr = new String[tempBooks.size()][5];
		
		for (int i = 0; i < tempBooks.size(); i++) {
			Book tBooks = tempBooks.get(i);
			dataStr[i][0] = tBooks.getBook_no() + "";
			dataStr[i][1] = tBooks.getBook_name();
			dataStr[i][2] = tBooks.getBook_author();
			dataStr[i][3] = tBooks.getBook_pos();
			dataStr[i][4] = tBooks.getBook_stock() + "";
			
			tableModel = new DefaultTableModel(dataStr, header);
		
			table.setModel(tableModel);
			table.getColumnModel().getColumn(1).setPreferredWidth(288);
			table.getColumnModel().getColumn(2).setPreferredWidth(114);
			
		}
		
	}
	
	public void enterPress() throws Exception{
		String header[] = {"no","제목","작가","위치","재고"};
		JComboBox searchCB = new JComboBox();
		BookService bookSV = new BookService();
		searchCB.setModel(new DefaultComboBoxModel(new String[] {"\uB3C4\uC11C\uBA85", "\uC791\uAC00\uBA85"}));
		try {
			int choiceNum = searchCB.getSelectedIndex();
			ArrayList<Book> tempBook = new ArrayList<Book>();
			
			switch (choiceNum) {
			case 0:						
					tempBook = bookSV.searchBook(searchTF.getText());						
				break;
			case 1:
				tempBook = bookSV.searchAuhor(searchTF.getText());
				break;
			}
			
			dataStr = new String[tempBook.size()][5];
			
			for (int i = 0; i < tempBook.size(); i++) {
				Book tBooks = tempBook.get(i);
				dataStr[i][0] = tBooks.getBook_no() + "";
				dataStr[i][1] = tBooks.getBook_name();
				dataStr[i][2] = tBooks.getBook_author();
				dataStr[i][3] = tBooks.getBook_pos();
				dataStr[i][4] = tBooks.getBook_stock() + "";
			}
			
			tableModel = new DefaultTableModel(dataStr, header);
			
			table.setModel(tableModel);
			table.getColumnModel().getColumn(1).setPreferredWidth(288);
			table.getColumnModel().getColumn(2).setPreferredWidth(114);
			for (int i = 0; i < dataStr.length; i++) {
				table.getColumnModel().getColumn(i).setResizable(false);
			}
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
	}
	public int getNo(){
		return no;
	}


   public void booknana () throws Exception{
	   String header[] = {"no","제목","작가","위치","재고"};
		JComboBox searchCB = new JComboBox();
		BookService bookSV = new BookService();
		searchCB.setModel(new DefaultComboBoxModel(new String[] {"\uB3C4\uC11C\uBA85", "\uC791\uAC00\uBA85"}));
		try {
			int choiceNum = searchCB.getSelectedIndex();
			ArrayList<Book> tempBook = new ArrayList<Book>();
			
				tempBook = bookSV.searchAuhor(searchTF.getText());
			
			dataStr = new String[tempBook.size()][5];
			
			for (int i = 0; i < tempBook.size(); i++) {
				Book tBooks = tempBook.get(i);
				dataStr[i][0] = tBooks.getBook_no() + "";
				dataStr[i][1] = tBooks.getBook_name();
				dataStr[i][2] = tBooks.getBook_author();
				dataStr[i][3] = tBooks.getBook_pos();
				dataStr[i][4] = tBooks.getBook_stock() + "";
			}
			
			tableModel = new DefaultTableModel(dataStr, header);
			
			table.setModel(tableModel);
			table.getColumnModel().getColumn(1).setPreferredWidth(288);
			table.getColumnModel().getColumn(2).setPreferredWidth(114);
			for (int i = 0; i < dataStr.length; i++) {
				table.getColumnModel().getColumn(i).setResizable(false);
			}
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
   }








}
}