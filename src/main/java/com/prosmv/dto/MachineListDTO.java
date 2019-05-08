package com.prosmv.dto;

import java.util.List;

import com.prosmv.domain.Machine;

public class MachineListDTO {

	private List<MachineDTO> machineDTOs;

	public MachineListDTO() {

	}

	public MachineListDTO(List<MachineDTO> machineDTOs) {
		this.machineDTOs = machineDTOs;
	}

	public List<MachineDTO> getMachineDTOs() {
		return machineDTOs;
	}

	public void setMachineDTOs(List<MachineDTO> machineDTOs) {
		this.machineDTOs = machineDTOs;
	}

}
