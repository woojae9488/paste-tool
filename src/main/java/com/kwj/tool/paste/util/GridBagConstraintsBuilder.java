package com.kwj.tool.paste.util;

import java.awt.*;

public class GridBagConstraintsBuilder {

	private int gridX = GridBagConstraints.RELATIVE;
	private int gridY = GridBagConstraints.RELATIVE;
	private int gridWidth = 1;
	private int gridHeight = 1;

	private double weightX = 0;
	private double weightY = 0;

	private int fill = GridBagConstraints.NONE;

	public GridBagConstraintsBuilder gridX(int gridX) {
		this.gridX = gridX;
		return this;
	}

	public GridBagConstraintsBuilder gridY(int gridY) {
		this.gridY = gridY;
		return this;
	}

	public GridBagConstraintsBuilder gridWidth(int gridWidth) {
		this.gridWidth = gridWidth;
		return this;
	}

	public GridBagConstraintsBuilder gridHeight(int gridHeight) {
		this.gridHeight = gridHeight;
		return this;
	}

	public GridBagConstraintsBuilder weightX(double weightX) {
		this.weightX = weightX;
		return this;
	}

	public GridBagConstraintsBuilder weightY(double weightY) {
		this.weightY = weightY;
		return this;
	}

	public GridBagConstraintsBuilder fill(int fill) {
		this.fill = fill;
		return this;
	}

	public GridBagConstraints build() {
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = this.gridX;
		constraints.gridy = this.gridY;
		constraints.gridwidth = this.gridWidth;
		constraints.gridheight = this.gridHeight;
		constraints.weightx = this.weightX;
		constraints.weighty = this.weightY;
		constraints.fill = this.fill;
		return constraints;
	}

}
