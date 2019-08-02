package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.AppFrame;

public class MenuExitListener implements ActionListener
{
   private AppFrame frame;

   public MenuExitListener(AppFrame frame)
   {
      this.frame = frame;
   }

   @Override
   public void actionPerformed(ActionEvent arg0)
   {
      frame.Exit();
   }
}
