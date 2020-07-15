package ui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import reserve.ReserveService;
import reserve.ReserveVo;
import javax.swing.JScrollPane;

public class MemberReserveConfirmPanel extends JPanel {

	MemberServiceJFrameMain mainFrame;
	private JTable reserveTB;
	DefaultTableModel tableModel;
	ReserveService reserveService;
	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public MemberReserveConfirmPanel(MemberServiceJFrameMain mainFrame) throws Exception {
		this.mainFrame = mainFrame;
		reserveService = new ReserveService();
		setLayout(new BorderLayout(0, 0));
		
		JPanel titleP = new JPanel();
		add(titleP, BorderLayout.NORTH);
		titleP.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton reserveConfirmButton = new JButton("\uC608\uB9E4 \uD604\uD669 \uCD9C\uB825");
		reserveConfirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					memberJTable();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		reserveConfirmButton.setBackground(new Color(218, 112, 214));
		reserveConfirmButton.setFont(new Font("굴림", Font.BOLD, 20));
		titleP.add(reserveConfirmButton);
		
		JPanel TableP = new JPanel();
		add(TableP, BorderLayout.CENTER);
		TableP.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		TableP.add(scrollPane);
		
		reserveTB = new JTable();
		scrollPane.setViewportView(reserveTB);
		
		JPanel buttonP = new JPanel();
		add(buttonP, BorderLayout.SOUTH);
		
		JButton mainB = new JButton("\uBA54\uC778\uD654\uBA74\uC73C\uB85C");
		mainB.setBackground(UIManager.getColor("textHighlight"));
		mainB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.changePanel(mainFrame.getReserveButton(),"main");
			}
		});
		buttonP.add(mainB);

	}

	private void memberJTable() throws Exception{
		
		Vector columnNames=new Vector();
		columnNames.add("이름");
		columnNames.add("영화제목");
		columnNames.add("극장");
		columnNames.add("날짜");
		columnNames.add("시간");
		columnNames.add("요금");
		Vector data=new Vector();
		
		ArrayList<ReserveVo> resList = reserveService.findResListByID(mainFrame.getLoginMember().getId());
		if(resList.size()==0) {
			JOptionPane.showMessageDialog(null, "예매 내역이 없습니다.", "", JOptionPane.INFORMATION_MESSAGE);
		}
		for (ReserveVo reserveVo : resList) {
			Vector rowVector = new Vector();
			rowVector.add(reserveVo.getResName());
			rowVector.add(reserveVo.getResMovie());
			rowVector.add(reserveVo.getResCity()+" " + reserveVo.getResTheater() + reserveVo.getResScreenAreaNum() + "상영관");
			rowVector.add(reserveVo.getResDate());
			rowVector.add(reserveVo.getResTime()+" : 00");
			rowVector.add(reserveVo.getFee());
			data.add(rowVector);
		}
		
		tableModel = new DefaultTableModel(data, columnNames);
		reserveTB.setModel(tableModel);
	}
	
	
}
