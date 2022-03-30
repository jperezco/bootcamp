import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { MyCoreModule } from 'src/lib/my-core';
import { CommonServicesModule } from '../common-services';
import { PIZZAS_COMPONENTES } from './componente.component';



@NgModule({
  declarations: [
    PIZZAS_COMPONENTES
  ],
  imports: [
    CommonModule, FormsModule, RouterModule.forChild([]),
    MyCoreModule, CommonServicesModule,
  ],
  exports: [PIZZAS_COMPONENTES, ]
})
export class PizzasModule { }
