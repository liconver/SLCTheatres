import { NgModule } from '@angular/core';
import {MatButtonModule} from '@angular/material/button';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatListModule} from '@angular/material/list';
import {MatDividerModule} from '@angular/material/divider';

const Materials = [
  MatButtonModule,
  MatSidenavModule,
  MatToolbarModule,
  MatListModule,
  MatDividerModule
];

@NgModule({
  imports: [
    Materials
  ],
  exports: [
    Materials
  ]
})
export class MaterialModule { }
