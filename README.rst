============
 DSP Bridge
============

`DSPBridge Project <http://www.omappedia.com/wiki/DSPBridge_Project>`_

`Linux OMAP Project <http://omappedia.org/wiki/Linux_OMAP_Kernel_Project>`_


Gumstix WaterSTORM
==================

https://www.gumstix.com/store/product_info.php?products_id=265

Gumstix DSP on Overo Water
++++++++++++++++++++++++++

`http://wiki.gumstix.org//index.php?title=Category:How_to_-_DSP`


Details
+++++++

Key Components
~~~~~~~~~~~~~~

* DM3730CBP100:

  1GHz ARM Cortex™-A8 DaVinci™ DM3730 high-performance microprocessor is
  part of a range of devices that succeed the OMAP3530 series
  devices. Includes a 720p HD DSP imaging and video accelerator and PowerVR
  SGX graphics accelerator with Open GL ES 2.0 and OpenVG support. The
  DM3730 has been designed to provide best in class ARM and graphics
  performance while delivering low power consumption. According to Texas
  Instruments, DM3730 is fully backward compatible with previous OMAP™
  processors.  spec_sheet

* Memory 512MB DDR and 512MB NAND @ 200MHz:

  Package-on-package (PoP) memory solution that minimizes power
  consumption, maximizes board space and increases speed.

* microSD card slot:

  Use this on-board microSD card slot on every Gumstix Overo and verdex pro
  COM to gain additional memory for programming and data storage

* TI TPS65950 Version A3:

  Manage all system power requirements of the Overo COM with this
  integrated power management IC from Texas Instruments.  spec_sheet

Mating Connectors
~~~~~~~~~~~~~~~~~

* FH26-27S-0.3SHW:

  27-pin connector (J5) to provide camera control signals from the top side
  of each Overo COM.  spec_sheet

* 2 x Headers (AVX):

  70-pin connectors (J1) & (J4) on each Overo COM for connecting an
  expansion board.  spec_sheet

Links to manufacturer's specification sheets are provided for reference.

Comparable parts might be substituted in manufacturing.

Further hardware information (I/O pinouts, Benchmarks, schematics and more)


TI Documentation
================

http://www.ti.com/product/dm3730#technicaldocuments

Communication between Linux (on GPP) and DSP/BIOS (on DSP) http://elinux.org/BeagleBoard/DSP_Clarification

* DSP Gateway
* DSP Link
* DSP Bridge
* Syslink

TI Documentation for DSP Bridge:

* TI `DSP/BIOS Bridge Application Integration Guide <https://gforge.ti.com/gf/download/docmanfileversion/15/662/DSPBridge_AppIntegration_Guide.pdf>`_
* TI `Programming Guide for DSP/BIOS Bridge <https://gforge.ti.com/gf/download/docmanfileversion/6/286/db_linux_pguide.pdf>`_
* TI `XDC Getting Started Guide <http://rtsc.eclipse.org/mediawiki-3.16/images/1/12/XDCtools_Getting_Started_Guide.pdf>`_
* TI `XDC Consumer User’s Guide <http://www.ti.com/general/docs/lit/getliterature.tsp?baseLiteratureNumber=spruex4&fileType=pdf>`_


TI Linux
++++++++

(This isn't too useful)

http://www.ti.com/tool/linuxdvsdk-dm37x
http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/dvsdk/DVSDK_4_00/latest/index_FDS.html

`TI Linux OMAP Project <http://omappedia.org/wiki/Linux_OMAP_Kernel_Project>`_

* TI OMAP Linux tree: http://git.kernel.org/cgit/linux/kernel/git/tmlind/linux-omap.git/
* TI OMAP 3 Linux integration tree: http://dev.omapzoom.org/pub/scm/integration/kernel-omap3.git
* TI OMAP 4 Linux integration tree: http://dev.omapzoom.org/pub/scm/integration/kernel-omap4.git


TI DM3730/25 Specs
++++++++++++++++++

* DM3730/25 Digital Media Processors:
  - Compatible with OMAP(tm) 3 Architecture
  - ARM(R) Microprocessor (MPU) Subsystem
* Up to 1-GHz ARM(R) Cortex(tm)-A8 Core Also supports 300, 600, and 800-MHz operation
* NEON(tm) SIMD Coprocessor
  - High Performance Image, Video, Audio (IVA2.2TM) Accelerator Subsystem
* Up to 800-MHz TMS320C64x+TM DSP Core Also supports 260, 520, and 660-MHz operation
* Enhanced Direct Memory Access (EDMA) Controller (128 Independent Channels)
* Video Hardware Accelerators
  - POWERVR SGXTM Graphics Accelerator (DM3730 only)
* Tile Based Architecture Delivering up to 20 MPoly/sec
* Universal Scalable Shader Engine: Multi-threaded Engine Incorporating Pixel and Vertex Shader Functionality
* Industry Standard API Support: OpenGLES 1.1 and 2.0, OpenVG1.0
* Fine Grained Task Switching, Load Balancing, and Power Management
* Programmable High Quality Image Anti-Aliasing
  - Advanced Very-Long-Instruction-Word (VLIW) TMS320C64x+TM DSP Core
* Eight Highly Independent Functional Units
* Six ALUs (32-/40-Bit); Each Supports Single 32- bit, Dual 16-bit, or Quad 8-bit, Arithmetic per Clock Cycle
* Two Multipliers Support Four 16 x 16-Bit Multiplies (32-Bit Results) per Clock Cycle or Eight 8 x 8-Bit Multiplies (16-Bit Results) per Clock Cycle
* Load-Store Architecture With Non-Aligned Support
* 64 32-Bit General-Purpose Registers
* Instruction Packing Reduces Code Size
* All Instructions Conditional
* Additional C64x+TM Enhancements
  - Protected Mode Operation
  - Expectations Support for Error Detection and Program Redirection
  - Hardware Support for Modulo Loop Operation TM
  - C64x+ L1/L2 Memory Architecture
* 32K-Byte L1P Program RAM/Cache (Direct Mapped)
* 80K-Byte L1D Data RAM/Cache (2-Way Set- Associative)
* 64K-Byte L2 Unified Mapped RAM/Cache (4- Way Set-Associative)
* 32K-Byte L2 Shared SRAM and 16K-Byte L2 ROM
  - C64x+TM Instruction Set Features
* Byte-Addressable (8-/16-/32-/64-Bit Data)
* 8-Bit Overflow Protection
* Bit-Field Extract, Set, Clear
* Normalization, Saturation, Bit-Counting
* Compact 16-Bit Instructions
* Additional Instructions to Support Complex Multiplies
  - External Memory Interfaces:
* SDRAM Controller (SDRC)
  - 16, 32-bit Memory Controller With 1G-Byte Total Address Space
  - Interfaces to Low-Power SDRAM
  - SDRAM Memory Scheduler (SMS) and Rotation Engine
* General Purpose Memory Controller (GPMC)
  - 16-bit Wide Multiplexed Address/Data


TI Tools
========

Must install cgt6x-6.0.7, bios_5_33_04, dsplib_c64Px_3_1_1_1

DSP/BIOS http://software-dl.ti.com/dsps/dsps_registered_sw/sdo_sb/targetcontent/bios/index.html
bios_setuplinux_5_33_04.bin http://software-dl.ti.com/dsps/dsps_registered_sw/sdo_sb/targetcontent/bios/bios_5_33/bios_5_33_06/exports/bios_setuplinux_5_33_04.bin

CGT C6000 https://www-a.ti.com/downloads/sds_support/TICodegenerationTools/download.htm
ti_cgt_c6000_6.0.7_setup_linux_x86.bin https://focus-webapps.ti.com/licreg/docs/swlicexportcontrol.tsp?form_type=2&prod_no=ti_cgt_c6000_6.0.7_setup_linux_x86.bin&ref_url=http://software-dl.ti.com/dsps/dsps_registered_sw/sdo_ccstudio/codegen/C6000/6.0.7

TMS320C6000 DSP Library (DSPLIB)
http://www.ti.com/tool/SPRC265
http://software-dl.ti.com/sdoemb/sdoemb_public_sw/dsplib/latest/index_FDS.html
dsplib_c64Px_3_1_1_1_Linux.bin http://software-dl.ti.com/sdoemb/sdoemb_public_sw/dsplib/latest/exports/dsplib_c64Px_3_1_1_1_Linux.bin

IQMath C64x+
http://www.ti.com/tool/sprc542
c64xplus-iqmath_2_01_04_00_Linux-x86_Setup.bin http://software-dl.ti.com/dsps/dsps_public_sw/c6000/web/c64p_iqmath/latest/exports//c64xplus-iqmath_2_01_04_00_Linux-x86_Setup.bin

XDC Tools
http://downloads.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/rtsc/
http://downloads.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/rtsc/3_25_05_94/exports/xdctools_setuplinux_3_25_05_94.bin


Make it Go!
===========

Install support packages::

  >$ sudo dpkg --add-architecture i386
  >$ sudo apt-get update
  >$ sudo apt-get install u-boot-tools libc6:i386 libstdc++5:i386

Create work directory::

  >$ mkdir $SOME_PATH/yocto/ti_pkgs

Download TI tools (from above) and put in `yocto/ti_pkgs` dir:

  #. create TI.com account
  #. download TI ti_cgt_c6000 6.0.7 and put in `yocto/ti_pkgs` dir
  #. download TI bios_setuplinux 5_33_04 and put in `yocto/ti_pkgs` dir
  #. download TI DSPLIB dsplib_c64Px_3_1_1_1_Linux.bin and put in `yocto/ti_pkgs` dir
  #. The TI tools use the i386 libraries from the support packages

Yocto file system build: http://gumstix.org/software-development/yocto-project.html::

  cd $SOME_PATH/yocto

  curl http://commondatastorage.googleapis.com/git-repo-downloads/repo >repo
  chmod a+x repo

  ./repo init -u git://github.com/gumstix/Gumstix-YoctoProject-Repo.git -b master
  ./repo sync
  cd poky
  git clone git@github.com:plastikos/yocto_gumstix_dspbridge.git meta-gumstix-dspbridge
  cd ..
  TEMPLATECONF=meta-gumstix-dspbridge/conf source ./poky/oe-init-build-env
  bitbake gumstix-console-image
  #bitbake core-image-minimal

Image SD Card::

  >$ poky/meta-gumstix-dspbridge/bin/gumstix_partition /dev/sdX $SOME_PATH/build/tmp/deploy/images core-image-minimal-overo

Boot:

  #. Plug in mini USB
  #. Start serial monitor: ::

     >$ screen /dev/ttyUSB0 115200

  #. Plug power
  #. Login with user `root` and no password

Load BIOS::

  >$ modprobe tidspbridge # unnecessary
  >$ /dspbridge/samples/cexec.out /dspbridge/dsp/ddspbase_tiomap3430.dof64P
  >$ /dspbridge/samples/ping.out 50

Cross Compile Environment::

  >$ bitabke meta-toolchain
  >$ tmp/deploy/sdk


Build DSP Progs
===============

Make a bitbake recipe

Build source::

  >$ bitbake -v -b $SOME_PATH/recipes-srf/dsp-demo_0.1.bb
