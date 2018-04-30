import java.io.IOException;

import javax.swing.JOptionPane;

import cd.domain.mediator.CdPersistence;
import cd.domain.mediator.CdTextFile;
import cd.domain.model.CdList;
import cd.view.CdGUI;
import cd.view.CdView;

public class Main
{
   public static void main(String args[])
   {
      try
      {
         CdPersistence storage = new CdTextFile("src/cds.txt");
         CdList cdList = storage.load();

         CdView view = new CdGUI();
         view.start(cdList);
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
   }
}