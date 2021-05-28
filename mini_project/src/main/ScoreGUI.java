package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import stage1.Stage1MainFrame;
import stage2.Stage2Bar;
import stage2.Stage2MainFrame;
import stage2.Stage2MyPanel;
import stage3.Stage3MainFrame;
import stage1.Stage1MainFrame;

/**
 * 
 * 게임이 끝났을 때 뜨는 GUI
 *
 */
@SuppressWarnings("serial")
public class ScoreGUI extends JFrame {

	private static final String EXIT = "게임 종료"; // 게임 종료 문자열
	private static final String BACK = "스테이지 선택하기"; // 스테이지 선택하기 문자열
	private static final String MAIN = "메인 메뉴";
	private static final String SCORE = "점수 보기";
	private static final String RANKING = "랭킹";
	private static final String[] RESTART_BACK_BUTTON = { BACK,MAIN,EXIT }; // 두 문자열 배열에 담기
	private static final String[] RANKING_SCORE_BUTTON = { SCORE, RANKING }; // 두 문자열 배열에 담기
	
	private JPanel panel; // 패널
	private JButton[] rightButtons; // 버튼
	private JButton[] leftButtons;
	
	
	
	
	/**
	 * @param listener
	 *                 <li>EXIT 버튼 동작</li>
	 *                 <li>BACK 버튼 동작</li>
	 *
	 */
	public ActionListener listener = new ActionListener() { // 버튼을 눌렀을 때 동작

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			switch (button.getText()) {
			case EXIT: { // 게임 종료

				setVisible(false);

				System.exit(0);

				break;
			}
			case BACK: { // 스테이지 선택하기

				setVisible(false);
				new MainGUI(getName());

				break;
			}
			case MAIN: {
				
				setVisible(false);
				new LoggedInMenu(getName());
				
				break;
			}
			case RANKING:{
				
				
				
				
				
			}
			case SCORE:{
				
				
				
				
				
				
			}
				
				
			}
		}

	};

	/**
	 * 
	 * 게임 제목, EXIT,BACK 버튼이 부착되어 있는 GUI
	 * 
	 * 
	 * @param title - 게임 제목 "벽돌 깨기"
	 */
	public ScoreGUI(String title) {

		super("벽돌 깨기");

		// 이미지 가져오기
		Image image2 = null; // 이미지 초기화
		try {
			File sourceimage = new File(
					"C:/Users/herom/PARK/java.project/src/image/background3.jpg"); // 경로
																																// 불러옴
			image2 = ImageIO.read(sourceimage); // 불러온 경로를 받아 이미지를 받아옴
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image changeImg = image2.getScaledInstance(800, 800, image2.SCALE_SMOOTH); // 이미지 수정 세부 설정
		ImageIcon changeIcon = new ImageIcon(changeImg); // 수정된 이미지를 생성

		// 패널에 이미지를 붙여줌
		panel = new JPanel() {
			public void paint(Graphics g) {

				g.drawImage(changeIcon.getImage(), 0, 0, null); // 이미지를 그려줌

			}

		};

		// 제목 설정
		JLabel j = new JLabel("랭킹 순위", SwingConstants.CENTER); // "벽돌깨기"라는 제목을 라벨로 생성
		j.setFont(new Font("궁서", Font.BOLD, 50)); // 제목의 폰트를 설
		j.setForeground(new Color(250, 98, 3)); // 제목의 글자색 설정
		j.setBounds(280, 50, 250, 100); // 제목의 위치
		this.add(j);

		// 버튼
		
		leftButtons = new JButton[RANKING_SCORE_BUTTON.length]; // 버튼 배열 공간 만들기
		
		for (int i = 0; i < RANKING_SCORE_BUTTON.length; ++i) {
			leftButtons[i] = new JButton(RANKING_SCORE_BUTTON[i]); // 버튼 생성
			leftButtons[i].setFont(new Font("고딕체", Font.CENTER_BASELINE, 25)); // 버튼 폰트 설정

			leftButtons[i].setForeground(new Color(33, 33, 33)); // 버튼 글자색
			leftButtons[i].setBackground(new Color(216, 216, 216)); // 버튼 배경색

			leftButtons[i].addActionListener(listener); // 버튼 동작 추가

			leftButtons[i].setLayout(null); // 버튼 배치 방식 자유롭게
			leftButtons[i].setBounds(200, 80 * 2 * (i + 1), 250, 100); // 버튼 위치 설정
			this.add(leftButtons[i]); // 버튼 패널에 추가

		}
		
		
		
		
		
		rightButtons = new JButton[RESTART_BACK_BUTTON.length]; // 버튼 배열 공간 만들기
		
		for (int i = 0; i < RESTART_BACK_BUTTON.length; ++i) {
			rightButtons[i] = new JButton(RESTART_BACK_BUTTON[i]); // 버튼 생성
			rightButtons[i].setFont(new Font("고딕체", Font.CENTER_BASELINE, 25)); // 버튼 폰트 설정

			rightButtons[i].setForeground(new Color(33, 33, 33)); // 버튼 글자색
			rightButtons[i].setBackground(new Color(216, 216, 216)); // 버튼 배경색

			rightButtons[i].addActionListener(listener); // 버튼 동작 추가

			rightButtons[i].setLayout(null); // 버튼 배치 방식 자유롭게
			rightButtons[i].setBounds(500, 80 * 2 * (i + 1), 250, 100); // 버튼 위치 설정
			this.add(rightButtons[i]); // 버튼 패널에 추가

		}
		
		

		setSize(800, 800); // 창 크기
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 창 종료 기본 설정
		setLocationRelativeTo(null);// 창 중앙에 배치
		add(panel); // 창에 패널을 부착
		setVisible(true); // 창이 보이게 설정
	}
	public static void main(String[] args) {
		new ScoreGUI("fdd");
	}
}

