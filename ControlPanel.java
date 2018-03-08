import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ControlPanel
  extends JPanel
  implements ActionListener
{
  private CrapsTable table;
  
  public ControlPanel(CrapsTable paramCrapsTable)
  {
    this.table = paramCrapsTable;
    JButton localJButton = new JButton("Roll");
    localJButton.addActionListener(this);
    add(localJButton);
  }
  
  public void actionPerformed(ActionEvent paramActionEvent)
  {
    if (!this.table.diceAreRolling()) {
      this.table.rollDice();
    }
  }
}