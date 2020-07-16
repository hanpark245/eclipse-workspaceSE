package bookcafe.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import bookcafe.book.Book;
import bookcafe.book.BookDao;
import bookcafe.book.BookService;
import bookcafe.main.BookcafeMain;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class BookEditModifyDialog extends JDialog {

	private BookService bookService;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField_0;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextArea textArea;
	// private JTextField textField_4;
	private BookPanel bookPanel;
	ArrayList<BookDao> bookList;
	private JTable table;
	Book searchBook;

	ArrayList<Book> book = new ArrayList<Book>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try {
			/*
			 * BookAddModifyDialog dialog = new BookAddModifyDialog(null);
			 * dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			 * dialog.setVisible(true);
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void bookList() throws Exception {
		ArrayList<Book> bookList = bookService.allViewBook();
		String bookStr = "";
		for (Book book : bookList) {
			bookStr = bookStr + book.toString() + "\n";
		}
		// textArea.setText(bookStr);
		System.out.println(bookStr);
	}

	private int bookCount() throws Exception {
		ArrayList<Book> bookList = bookService.allViewBook();
		return bookList.size();
	}

	/**
	 * Create the dialog.
	 */
	
	
	
	public BookEditModifyDialog(BookPanel bp) throws Exception{
		this.bookPanel=bp;
		bookService = new BookService();
		setTitle("\uC218\uC815");
		setBounds(100, 100, 258, 327);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		Book br = new Book();
	
		
		JLabel lblNewLabel = new JLabel("\uC81C\uBAA9");
		lblNewLabel.setBounds(20, 64, 57, 15);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC791\uAC00");
		lblNewLabel_1.setBounds(20, 104, 57, 15);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uC704\uCE58");
		lblNewLabel_2.setBounds(20, 142, 57, 15);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uC7AC\uACE0");
		lblNewLabel_3.setBounds(20, 180, 57, 15);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\uBC88\uD638");
		lblNewLabel_4.setBounds(20, 23, 57, 15);
		contentPanel.add(lblNewLabel_4);
		
		
		//int choiceRow = table.getSelectedRow();
		int no = bp.getNo();
		searchBook = bp.bookSV.searchBook(no);
		
		textField_0 = new JTextField();
		textField_0.setBounds(70, 61, 116, 21);
		contentPanel.add(textField_0);
		textField_0.setColumns(10);
		textField_0.setText(searchBook.getBook_name());
		
		textField_1 = new JTextField();
		textField_1.setBounds(70, 101, 116, 21);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText(searchBook.getBook_author());
		
		textField_2 = new JTextField();
		textField_2.setBounds(70, 139, 116, 21);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setText(searchBook.getBook_pos());
		
		textField_3 = new JTextField();
		textField_3.setBounds(70, 177, 116, 21);
		contentPanel.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setText(Integer.toString(searchBook.getBook_stock()));
		/*
		textField_4 = new JTextField();
		textField_4.setBounds(70, 20, 116, 21);
		contentPanel.add(textField_4);
		textField_4.setColumns(10);
		*/

			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			// ���� ��ư
				JButton okButton = new JButton("Edit");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

					/*
						int noooo = 0;						
							ArrayList<Book> tempBook;
							try {
								noooo = bookCount() + 1;
							} catch (Exception e2) {
								e2.printStackTrace();
							}
							System.out.println("dsdfsdf:"+noooo);
					*/		
					int    a = searchBook.getBook_no();
					String b = textField_0.getText();
					String c = textField_1.getText();
					String d = textField_2.getText();
					int e = Integer.parseInt(textField_3.getText());
					try {
						bp.bookSV.updatBook(new Book(a,b, c, d, e));
						bookPanel.seeAllClick();
						dispose();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			
				//ĵ����ư
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
	}
}
