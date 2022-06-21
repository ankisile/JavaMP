import java.awt.Font;
import java.util.Calendar;

import javax.swing.JLabel;

class MyLabel extends JLabel implements Runnable {
		private Thread timerThread = null;
		public MyLabel() { //라벨 생성
			setText(makeClockText());
			setFont(new Font("TimesRoman", Font.ITALIC, 25));
			setHorizontalAlignment(JLabel.CENTER);
			timerThread = new Thread(MyLabel.this);
			timerThread.start();
		}
		
		public String makeClockText() { //연도, 달, 일, 시간 문자열을 리턴하는 함수
			Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH);
			int day = c.get(Calendar.DAY_OF_MONTH);
			int hour = c.get(Calendar.HOUR_OF_DAY);
			int min = c.get(Calendar.MINUTE);
			int second = c.get(Calendar.SECOND);
			
			String clockText = Integer.toString(year);
			clockText = clockText.concat("년 ");
			clockText = clockText.concat(Integer.toString(month+1));
			clockText = clockText.concat("월 ");
			clockText = clockText.concat(Integer.toString(day));
			clockText = clockText.concat("일 ");
			clockText = clockText.concat(Integer.toString(hour));
			clockText = clockText.concat(":");
			clockText = clockText.concat(Integer.toString(min));
			clockText = clockText.concat(":");
			clockText = clockText.concat(Integer.toString(second));
			clockText = clockText.concat(" ");

			return clockText;
		}
		
		@Override
		public void run() { 
			while(true) {
				try {
					Thread.sleep(1000);
				}
				catch(InterruptedException e){return;}
				setText(makeClockText());
			}
		}
	}
