import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ButtonHandler implements ActionListener
{
   private CdList cdList;
   private CdGUI gui;

   public ButtonHandler(CdList cdList, CdGUI gui)
   {
      this.cdList = cdList;
      this.gui = gui;
   }

   @Override
   public void actionPerformed(ActionEvent e)
   {
      if (!(e.getSource() instanceof JButton))
         return;

      if (((JButton) e.getSource()).getText().startsWith("List"))
      {
         gui.show("" + cdList);
      }
      else if (((JButton) e.getSource()).getText().startsWith("Add"))
      {
         String msg = "Add method - not implemented";
         gui.show(msg);
      }
      else if (((JButton) e.getSource()).getText().startsWith("Remove"))
      {
         String input = gui.get("title");
         if (input == null)
            return;
         String msg = "";
         Cd cd = cdList.removeFirstCdByTitle(input);
         if (cd != null)
         {
            msg = "REMOVED: \n" + cd.toString();
         }
         else
         {
            msg = "No CD with title: \"" + input + "\" found";
         }
         gui.show(msg);
      }
      else if (((JButton) e.getSource()).getText().startsWith("Search"))
      {
         String input = gui.get("title");
         if (input == null)
            return;
         String msg = "";
         CdList list = cdList.getCdsByTitle(input);
         for (int i = 0; i < list.getNumberOfCds(); i++)
         {
            msg += list.getCD(i) + "\n\n\n";
         }
         if (list.getNumberOfCds() == 0)
         {
            msg = "No CD with title: \"" + input + "\" found";
         }
         gui.show(msg);
      }
      else if (((JButton) e.getSource()).getText().startsWith("Quit"))
      {
         System.exit(0);
      }
   }
}