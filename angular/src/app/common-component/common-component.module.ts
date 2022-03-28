import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ShowErrorMessagesComponent } from './show-error-messages/show-error-messages.component';
import { FormButtonsComponent } from './form-buttons/form-buttons.component';



@NgModule({
  declarations: [ShowErrorMessagesComponent, FormButtonsComponent],
  imports: [
    CommonModule
  ],
  exports: [ShowErrorMessagesComponent, FormButtonsComponent],
})
export class CommonComponentModule { }
