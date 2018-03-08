import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

public class CrapsTable extends JPanel implements ActionListener
{
  private RollingDie die1;
  private RollingDie die2;
  private final int delay = 20;
  private Timer clock;
  private CrapsGame game;
  private DisplayPanel display;
  
  public CrapsTable(DisplayPanel paramDisplayPanel)
  {
    setBackground(Color.green);
    setBorder(new LineBorder(Color.ORANGE.darker(), 3));
    this.display = paramDisplayPanel;
    this.game = new CrapsGame();
    this.die1 = new RollingDie();
    this.die2 = new RollingDie();
    this.clock = new Timer(20, this);
  }
  
  public void rollDice()
  {
    RollingDie.setBounds(3, getWidth() - 3, 3, getHeight() - 3);
    this.die1.roll();
    this.die2.roll();
    this.clock.start();
  }
  
  public void actionPerformed(ActionEvent paramActionEvent)
  {
    if (diceAreRolling())
    {
      if (!this.clock.isRunning()) {
        this.clock.restart();
      }
      if (this.die1.isRolling()) {
        this.die1.avoidCollision(this.die2);
      } else if (this.die2.isRolling()) {
        this.die2.avoidCollision(this.die1);
      }
    }
    else
    {
      this.clock.stop();
      int i = this.die1.getNumDots() + this.die2.getNumDots();
      int j = this.game.processRoll(i);
      int k = this.game.getPoint();
      this.display.update(j, k);
    }
    repaint();
  }
  
  public boolean diceAreRolling()
  {
    return (this.die1.isRolling()) || (this.die2.isRolling());
  }
  
  public void paintComponent(Graphics paramGraphics)
  {
    super.paintComponent(paramGraphics);
    this.die1.draw(paramGraphics);
    this.die2.draw(paramGraphics);
  }
}
