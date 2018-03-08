import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DisplayPanel extends JPanel
{
  private JTextField wonText;
  private JTextField lostText;
  private JTextField pointText;
  private int wonCount;
  private int lostCount;
  
  public DisplayPanel()
  {
    super(new GridLayout(2, 3, 10, 0));
    setBorder(new EmptyBorder(0, 0, 5, 0));
    
    add(new JLabel("    Won:"));
    add(new JLabel("    Lost:"));
    add(new JLabel("    Point:"));
    
    Font localFont = new Font("Monospaced", 1, 16);
    
    this.wonText = new JTextField("  0", 5);
    this.wonText.setFont(localFont);
    this.wonText.setEditable(false);
    this.wonText.setBackground(Color.WHITE);
    add(this.wonText);
    
    this.lostText = new JTextField("  0", 5);
    this.lostText.setFont(localFont);
    this.lostText.setEditable(false);
    this.lostText.setBackground(Color.WHITE);
    add(this.lostText);
    
    this.pointText = new JTextField(5);
    this.pointText.setFont(localFont);
    this.pointText.setEditable(false);
    this.pointText.setBackground(Color.DARK_GRAY);
    add(this.pointText);
  }
  
  public void update(int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0)
    {
      this.wonCount += 1;
      this.wonText.setText("  " + this.wonCount);
      this.pointText.setText("");
      this.pointText.setBackground(Color.DARK_GRAY);
    }
    else if (paramInt1 < 0)
    {
      this.lostCount += 1;
      this.lostText.setText("  " + this.lostCount);
      this.pointText.setText("");
      this.pointText.setBackground(Color.DARK_GRAY);
    }
    else
    {
      this.pointText.setText("  " + paramInt2);
      this.pointText.setBackground(Color.YELLOW);
    }
  }
}
